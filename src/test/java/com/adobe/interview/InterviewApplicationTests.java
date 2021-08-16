package com.adobe.interview;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

// Test class added ONLY to cover main() invocation not covered by application tests.
@SpringBootTest
class InterviewApplicationTests {

	@Test
	public void main() {
		InterviewApplication.main(new String[] {});
	 }

}