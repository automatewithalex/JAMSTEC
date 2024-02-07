@RUN
Feature: Contact Form Functionality

  As a visitor of AutomateWithAlex.com
  I want to use the contact form to get in touch with Alex
  So that I can inquire about automation services or provide feedback

  Background:
    Given I am on the "Home" page of AutomateWithAlex.com

  Scenario: Submitting a valid contact form
    When I fill in the "First name" field with "John"
    When I fill in the "Last name" field with "Doe"
    And I fill in the "Email" field with "john.doe@example.com"
    And I fill in the "Message" field with "I am interested in learning more about your services."
    And I click the "Submit" button
    Then I should see a confirmation message indicating my message was sent successfully

  Scenario: Attempt to submit contact form with missing information
    When I fill in the "First name" field with "Jane"
    When I fill in the "Last name" field with "Doe"
    And I leave the "Email" field empty
    And I fill in the "Message" field with "Please contact me as soon as possible."
    And I click the "Submit" button
    Then I should see an error message indicating the "Email" field is required

  Scenario: Submitting contact form with an invalid email address
    When I fill in the "First name" field with "Alice"
    When I fill in the "Last name" field with "Smith"
    And I fill in the "Email" field with "alice.smith"
    And I fill in the "Message" field with "I have a question about your pricing."
    And I click the "Submit" button
    Then I should see an error message indicating the email address is invalid

  Scenario: Submit contact form without a message
    When I fill in the "First name" field with "Bob"
    When I fill in the "Last name" field with "Martin"
    And I fill in the "Email" field with "bob.martin@example.com"
    And I leave the "Message" field empty
    And I click the "Submit" button
    Then I should see an error message indicating the "Message" field is required