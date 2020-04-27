package com.linsoong.leetcode.passed;

/*
Suppose you are given the following code:

class FooBar {
  public void foo() {
    for (int i = 0; i < n; i++) {
      print("foo");
    }
  }

  public void bar() {
    for (int i = 0; i < n; i++) {
      print("bar");
    }
  }
}
The same instance of FooBar will be passed to two different threads. Thread A will call foo() while thread B will call bar(). Modify the given program to output "foobar" n times.

 

Example 1:

Input: n = 1
Output: "foobar"
Explanation: There are two threads being fired asynchronously. One of them calls foo(), while the other calls bar(). "foobar" is being output 1 time.
Example 2:

Input: n = 2
Output: "foobarfoobar"
Explanation: "foobar" is being output 2 times.
 */
public class Q1115_PrintFooBarAlternately {
	
	volatile boolean foo_marker = false;
	private int n;

	public Q1115_PrintFooBarAlternately(int n){
		this.n = n;
	}
	
    public void foo(Runnable printFoo) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            
        	while(foo_marker) {
        		Thread.sleep(1l);
        	}
        	
        	// printFoo.run() outputs "foo". Do not change or remove this line.
        	printFoo.run();
        	
        	foo_marker = true;
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            
        	while(!foo_marker) {
        		Thread.sleep(1l);
        	}
        	
            // printBar.run() outputs "bar". Do not change or remove this line.
        	printBar.run();
        	
        	foo_marker = false;
        }
    }
	
	public static void main(String[] args) {
		
	}

}
