# Who: Junda Lou
# What: Fibonacci.asm
# Why: A program to calculate the nth Fibonacci number
# When: 5.12.2017
# How: Iterative loop

.data
Prompt: .asciiz "Please enter the integer n to be the nth Fibonacci number: "

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

	li $v0, 1
	move $a0, $t0
	syscall
