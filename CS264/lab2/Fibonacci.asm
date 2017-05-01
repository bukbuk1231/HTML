# Who: Junda Lou
# What: Fibonacci.asm
# Why: A program to calculate the nth Fibonacci number
# When: 5.12.2017
# How: Iterative loop

.data
Prompt: .asciiz "Please enter the integer n to be the nth Fibonacci number: "
Result:	.asciiz "The nth Fibonacci number is: "
Portion: .asciiz "Portion of the sequence is: ......"
whiteSpace: .asciiz " "
newLine: .asciiz "\n"
error:	.asciiz "Error!\n"
	
.align 2
list:	.word 10000

.text
.globl main

main:
	la $a0, Prompt
	li $v0, 4
	syscall
	li $v0, 5
	syscall
	move $t0, $v0

	beq $t0, $zero, Error
	
	li $t1, 0
	li $t2, 1
	li $t3, 0
	li $t4, 1
	la $t5, list
	
Loop:
	addu $t3, $t1, $t2
	move $t1, $t2
	move $t2, $t3
	addiu $t4, $t4, 1
	sw $t3, 0($t5)
	addiu $t5, $t5, 4
	bne $t4, $t0, Loop

ShowResult:
	la $a0, Result
	li $v0, 4
	syscall
	
	li $v0, 1
	addiu $t5, $t5, -4
	lw $a0, 0($t5)
	#move $a0, $t1
	syscall

	la $a0, newLine
	li $v0, 4
	syscall

ShowPortion:
	la $a0, Portion
	li $v0, 4
	syscall
	li $t1, 0
	blt $t0, 5, ShowLoop1
	addiu $t5, $t5, -16

ShowLoop2:
	lw $a0, 0($t5)
	li $v0, 1
	syscall
	addiu $t5, $t5, 4
	addiu $t1, $t1, 1
	la $a0, whiteSpace
	li $v0, 4
	syscall
	bne $t1, 5, ShowLoop2
	j End

ShowLoop1:
	la $t5, list
	lw $a0, 0($t5)
	li $v0, 1
	syscall
	la $a0, whiteSpace
	li $v0, 4
	syscall
	addiu $t5, $t5, 4
	addiu $t1, $t1, 1
	bne $t1, $t0, ShowLoop1
	j End
	
Error:
	la $a0, error
	li $v0, 4
	syscall
	j End

End:
	li $v0, 10
	syscall
