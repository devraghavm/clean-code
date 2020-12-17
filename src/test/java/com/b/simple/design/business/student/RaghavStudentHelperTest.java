package com.b.simple.design.business.student;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class RaghavStudentHelperTest {

	RaghavStudentHelper helper = new RaghavStudentHelper();
	
	@Test
	public void testIsGradeB() {
		assertEquals(false,helper.isGradeB(30, false));
		assertEquals(false,helper.isGradeB(50, false));
		assertEquals(true,helper.isGradeB(51, false));
		assertEquals(true,helper.isGradeB(80, false));
		assertEquals(false,helper.isGradeB(81, false));
		
		assertEquals(false,helper.isGradeB(30, true));
		assertEquals(false,helper.isGradeB(50, true));
		assertEquals(true,helper.isGradeB(51, true));
		assertEquals(true,helper.isGradeB(80, true));
		assertEquals(true,helper.isGradeB(81, true));
		assertEquals(true,helper.isGradeB(89, true));
		assertEquals(true,helper.isGradeB(90, true));
		assertEquals(false,helper.isGradeB(91, true));

	}

	@Test
	public void testGetGrade() {

		assertEquals(RaghavStudentHelper.Grade.A,helper.getGrade(99, false));
		assertEquals(RaghavStudentHelper.Grade.A,helper.getGrade(91, false));
		assertEquals(RaghavStudentHelper.Grade.B,helper.getGrade(85, false));
		assertEquals(RaghavStudentHelper.Grade.B,helper.getGrade(51, false));
		assertEquals(RaghavStudentHelper.Grade.C,helper.getGrade(50, false));
		assertEquals(RaghavStudentHelper.Grade.C,helper.getGrade(45, false));

		assertEquals(RaghavStudentHelper.Grade.A,helper.getGrade(99, true));
		assertEquals(RaghavStudentHelper.Grade.A,helper.getGrade(96, true));
		assertEquals(RaghavStudentHelper.Grade.B,helper.getGrade(89, true));
		assertEquals(RaghavStudentHelper.Grade.B,helper.getGrade(56, true));
		assertEquals(RaghavStudentHelper.Grade.C,helper.getGrade(55, true));
		assertEquals(RaghavStudentHelper.Grade.C,helper.getGrade(50, true));
		assertEquals(RaghavStudentHelper.Grade.C,helper.getGrade(45, true));

		//Will fail due to wrong implementation
		//assertEquals("B",helper.getGrade(95, true));
		//assertEquals("B",helper.getGrade(90, false));
	}

	@Test
	public void testWillQualifyForQuiz() {
		assertEquals("NO",helper.willQualifyForQuiz(15, 25, false));
		assertEquals("NO",helper.willQualifyForQuiz(20, 20, false));
		assertEquals("MAYBE",helper.willQualifyForQuiz(21, 21, false));
		assertEquals("MAYBE",helper.willQualifyForQuiz(25, 25, false));
		assertEquals("MAYBE",helper.willQualifyForQuiz(79, 79, false));
		assertEquals("YES",helper.willQualifyForQuiz(80, 30, false));
		assertEquals("YES",helper.willQualifyForQuiz(85, 30, false));
		assertEquals("YES",helper.willQualifyForQuiz(30, 90, false));
		
		assertEquals("NO",helper.willQualifyForQuiz(15, 25, true));
		assertEquals("NO",helper.willQualifyForQuiz(20, 20, true));
		assertEquals("NO",helper.willQualifyForQuiz(21, 21, true));
		assertEquals("NO",helper.willQualifyForQuiz(25, 25, true));
		assertEquals("MAYBE",helper.willQualifyForQuiz(27, 34, true));
		assertEquals("MAYBE",helper.willQualifyForQuiz(79, 79, true));
		assertEquals("MAYBE",helper.willQualifyForQuiz(80, 30, true));
		assertEquals("MAYBE",helper.willQualifyForQuiz(80, 84, true));
		assertEquals("YES",helper.willQualifyForQuiz(85, 30, true));
		assertEquals("YES",helper.willQualifyForQuiz(30, 90, true));

	}

}
