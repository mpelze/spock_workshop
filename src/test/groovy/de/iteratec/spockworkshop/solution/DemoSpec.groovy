package de.iteratec.spockworkshop.solution

import spock.lang.Specification
import spock.lang.Unroll

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

    @Unroll
    def "Adding #a and #b in Java works (data table)"(int a, int b, int result) {
        when: "I add the two variables a and b"
        def c = a + b

        then: "I expect the result to be the sum of a and b"
        c == result

        where:
        a | b | result
        1 | 2 | 3
        1 | 3 | 4
        2 | 6 | 8
        4 | 2 | 6
    }

    // Task 3: As an alternative to data tables use data pipes to write your test case.

    @Unroll
    def "Adding #a and #b in Java works (data pipes)"(int a, int b, int result) {
        when: "I add the two variables a and b"
        def c = a + b

        then: "I expect the result to be the sum of a and b"
        c == result

        where:
        a << [1, 3, 5]
        b << [3, 2, 7]
        // result << [4, 5, 12]
        result << provideResults()
    }

    int[] provideResults() {
        // Here you could access a database or whatever to provide test data.
        return [4, 5, 12]
    }

    // Task 4: Make your test fail to see how Spock reports the test failure.

    // Change one of the numbers in the above tests ;-)

}
