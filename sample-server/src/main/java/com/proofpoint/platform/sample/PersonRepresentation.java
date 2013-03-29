/*
 * Copyright 2010 Proofpoint, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.proofpoint.platform.sample;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import java.net.URI;

public class PersonRepresentation
{
    private final Person person;

    @JsonCreator
    public PersonRepresentation(@JsonProperty("email") String email, @JsonProperty("name") String name)
    {
        this(new Person(email, name));
    }

    private PersonRepresentation(Person person)
    {
        this.person = person;
    }

    @NotNull(message = "is missing")
    @Pattern(regexp = "[^@]+@[^@]+", message = "is malformed")
    public String getEmail()
    {
        return person.getEmail();
    }

    @NotNull(message = "is missing")
    public String getName()
    {
        return person.getName();
    }

    public Person toPerson()
    {
        return person;
    }
}