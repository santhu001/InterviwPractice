/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interviewpractice.marsrover;

import java.util.Objects;

/**
 *
 * @author santhosh
 */
public class Rover {
       	public static final Integer N = 1;
    	public static final Integer E = 2;
    	public static final Integer S = 3;
    	public static final Integer W = 4;
    	Integer x = 0;
    	Integer y = 0;
    	Integer facing = N;
    	public Rover() {
    	}
    	public void setPosition(Integer x, Integer y, Integer facing) {
    		this.x = x;
    		this.y = y;
    		this.facing = facing;
    	}
    	public void printPosition() {
    		char dir = 'N';
    		if (null != facing) switch (facing) {
                       case 1:
                           dir = 'N';
                           break;
                       case 2:
                           dir = 'E';
                           break;
                       case 3:
                           dir = 'S';
                           break;
                       case 4:
                           dir = 'W';
                           break;
                       default:
                           break;
                   }
    		System.out.println(x   +" " +  y  + " " +  dir);
    	}
    	public void process(String commands) {
    		for (int idx = 0; idx < commands.length(); idx++ ) {
    			process(commands.charAt(idx));
    		}
    	}
    	private void process(Character command) {
                   switch (command) {
                       case 'L':
                           turnLeft();
                           break;
                       case 'R':
                           turnRight();
                           break;
                       case 'M':
                           move();
                           break;
                       default:
                           throw new IllegalArgumentException(
                                   "Speak in Mars language, please!");
                   }
    	}
    	private void move() {
    		if (Objects.equals(facing, N)) {
    			this.y++  ;
    		} else if (Objects.equals(facing, E)) {
    			this.x++  ;
    		} else if (Objects.equals(facing, S)) {
    			this.y--;
    		} else if (Objects.equals(facing, W)) {
    			this.x--;
    		}
    	}
    	private void turnLeft() {
    		facing = (facing - 1) < N ? W : facing - 1;
    	}
    	private void turnRight() {
    		facing = (facing +  1) > W ? N : facing +  1;
    	}
    	public static void main(String args[]) {
    		Rover rover = new Rover();
    		rover.setPosition(1, 2, N);
    		rover.process("LMLMLMLMM");
    		rover.printPosition(); // prints 1 3 N
    		rover.setPosition(3, 3, E);
    		rover.process("MMRMMRMRRM");
    		rover.printPosition(); // prints 5 1 E
    	} 
}
