/*
 * Copyright 2015 Codice Foundation
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package org.codice.testify.assertions.Contains;

import org.codice.testify.objects.AssertionStatus;
import org.codice.testify.objects.Response;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ContainsAssertionTest {

    @Test
    public void testNoAssertionInfo() {
        ContainsAssertion containsAssertion = new ContainsAssertion();
        AssertionStatus assertionStatus = containsAssertion.evaluateAssertion(null, new Response("A very cool response"));
        assert ( assertionStatus.getFailureDetails().equals("No contained string provided with assertion") );
    }

    @Test
    public void testNoResponse() {
        ContainsAssertion containsAssertion = new ContainsAssertion();
        AssertionStatus assertionStatus = containsAssertion.evaluateAssertion("cool", new Response(null));
        assert ( assertionStatus.getFailureDetails().equals("No processor response") );
    }

    @Test
    public void testContainedString() {
        ContainsAssertion containsAssertion = new ContainsAssertion();
        AssertionStatus assertionStatus = containsAssertion.evaluateAssertion("cool", new Response("A very cool response"));
        assert ( assertionStatus.isSuccess() );
    }

    @Test
    public void testStringNotContained() {
        ContainsAssertion containsAssertion = new ContainsAssertion();
        AssertionStatus assertionStatus = containsAssertion.evaluateAssertion("Not Cool", new Response("A very cool response"));
        assert ( assertionStatus.getFailureDetails().equals("Response does not contain assertion string") );
    }

}
