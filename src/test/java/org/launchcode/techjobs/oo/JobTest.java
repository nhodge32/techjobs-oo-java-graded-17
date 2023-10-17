package org.launchcode.techjobs.oo;

import org.junit.Test;

import static org.testng.Assert.*;

public class JobTest {
    //TODO: Create your unit tests here
    @Test
    public void testSettingJobId() {
        //create 2 Job objects using empty constructor
        Job job1 = new Job();
        Job job2 = new Job();
        //assertNotEquals verify Ids are diff
        assertNotEquals(job1.getId(), job2.getId());
        //Run test to check
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        //declare and initialize a new Job object
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        //use assertTrue and assertEquals to test the constructor
        //assigns both the class and value of each field
        //5 assert statements for each (assertTrue and assertEquals)
        //assertTrue might be testing the instances
        //not sure about these
        assertTrue(job1 instanceof Job);
        assertTrue(job1.getEmployer() instanceof Employer);
        assertTrue(job1.getLocation() instanceof Location);
        assertTrue(job1.getPositionType() instanceof PositionType);
        assertTrue(job1.getCoreCompetency() instanceof  CoreCompetency);

        //do these fields equal what they should equal
        assertEquals(job1.getName(), "Product tester");
        assertEquals(job1.getEmployer().getValue(), "ACME");
        assertEquals(job1.getLocation().getValue(), "Desert");
        assertEquals(job1.getPositionType().getValue(), "Quality control");
        assertEquals(job1.getCoreCompetency().getValue(), "Persistence");
    }

    @Test
    public void testJobsForEquality() {
        //generate 2 Job objects with identical field values EXCEPT for id
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job job2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        //test equals returns false
        boolean isEqual = job1.equals(job2);
        assertFalse(isEqual);
        //assertNotEquals(job1, job2); what is the difference between these 2 approaches
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job job = new Job();
        assertEquals(job.toString(), System.lineSeparator() + job.getId() + System.lineSeparator());
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals(job.toString(), System.lineSeparator() + "ID: " + job.getId() + "\nName: " + job.getName() +
                "\nEmployer: " + job.getEmployer() + "\nLocation: " + job.getLocation() + "\nPosition Type: " + job.getPositionType() +
                "\nCore Competency: " + job.getCoreCompetency() + System.lineSeparator());
    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job job = new Job("", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));
        assertEquals(job.toString(), System.lineSeparator() + "ID: " + job.getId() + "\nName: Data not available\nEmployer: Data not available" +
                "\nLocation: Data not available\nPosition Type: Data not available\nCore Competency: Data not available" + System.lineSeparator());
    }
}
