# All in one line with a single space in between
# Junda Lou
# 4.15.2017
# CS264

.data
Input: .asciiz "Please enter 20 integers(one per line):\n"
Prompt: .asciiz "Here are the 20 integers in the array:\n"
whiteSpace: .asciiz " "

.align 2
list: .space 80



.text
.globl main
main:
	li $v0, 4	
	la $a0, Input
	syscall	
	li $t0, 0
	la $t1, list

ReadLoop:
	li $v0, 5
	syscall
	sw $v0, 0($t1)
	addu $t0, $t0, 1
	addu $t1, $t1, 4
	bne $t0, 20, ReadLoop
	li $t0, 0
	la $t1, list
	la $a0, Prompt
	li $v0, 4
	syscall
	
Loop:		
	lw $a0, 0($t1)
	li $v0, 1
	syscall
	la $a0, whiteSpace
	li $v0, 4
	syscall
	addu $t0, $t0, 1
	addu $t1, $t1, 4		
	bne $t0, 20, Loop

End:
	li $v0, 10
	syscall
	