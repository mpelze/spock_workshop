package de.iteratec.spockworkshop

import spock.lang.Specification

class DemoSpec extends Specification {

    def "Adding numbers in Java works"() {
        given:
        def a = 1
        def b = 2

        when: "I add the two variables a and b"
        def c = a + b

        then: "I expect the result to be the sum of a and b"
        c == 3
    }

    // Task 1: Extend this test case to run with multiple values for a, b and c. Hint: Use data tables
    // Task 2: Give each iteration of your data table test case a unique name containing the values for a, b and c (Hint: use @Unroll)
    // Task 3: As an alternative to data tables use data pipes to write your test case.
    // Task 4: Make your test fail to see how Spock reports the test failure.
}
