package stackandqueue_04;

import stackandqueue_04.IntStack.EmptyIntStackException;
import stackandqueue_04.IntStack.OverflowIntStackException;
import java.util.Scanner;

public class IntStack{
	private int max;
	private int ptr;
	private int[] stk;
	
	IntStack(int capacity){
		ptr = 0;
		max = capacity;
		stk = new int[max];
	}
	
	public class EmptyIntStackException extends RuntimeException{
		public EmptyIntStackException() {}		
	}
	
	public class OverflowIntStackException extends RuntimeException{
		public OverflowIntStackException() {}
	}
	
	
	public int push(int x) throws EmptyIntStackException {
		if(ptr>=max) {
			throw new EmptyIntStackException();
		}
		return stk[ptr++] = x;
	}
	public void pop() throws OverflowIntStackException {
		if(ptr <= 0) {
			throw new OverflowIntStackException();
		}
		ptr--;
	}
	public void show() {
		for(int i = 0; i<ptr; i++) {
			System.out.print(stk[i]+" ");
		}
		System.out.println("");
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("������ ������: "); int num = sc.nextInt();
		IntStack s = new IntStack(num);
		
		while(true) {
			int x;
			System.out.print("[1]Ǫ�� [2]�� [3]Ȯ��[4]����: "); int menu = sc.nextInt();
			
			switch(menu) {
			case 1:
				System.out.print("push�� ������: "); x = sc.nextInt();
				try {
					s.push(x);
				}catch(OverflowIntStackException e){
					System.out.println("������ �� ã���ϴ�..");
				}
				break;
			case 2:
				try {
					s.pop();
				}catch(EmptyIntStackException e) {
					System.out.println("������ ����ֽ��ϴ�.");
				}
				break;
			case 3:
				s.show();
				break;
			}
			if(menu == 4) {
				System.out.println("���α׷� ����.");
				break;
			}
		}
	}
	
}






