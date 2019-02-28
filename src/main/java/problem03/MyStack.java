package problem03;

import java.util.Arrays;

public class MyStack {
	
	private String[] buffer;
	int buffer_top;
	int buffer_size;
	
	public MyStack( int size ) {
		buffer_top = -1;
		buffer_size = size;
		buffer = new String [size];
	}
	
	public void push(String item) {
		if(buffer_top >= buffer_size-1) {
			buffer = Arrays.copyOf(buffer, size());
		}
		buffer[++buffer_top] = item;
	}

	public String pop() {
		return buffer_top >= 0 ? buffer[buffer_top--] : null;
	}

	public boolean isEmpty() {
		boolean isEmpty = buffer_top < 0;
		
		return isEmpty;
	}
	
	public int size() {
		// 사이즈가 초과될시 2배로 늘려준다.
		return buffer_size*2;
	}
}