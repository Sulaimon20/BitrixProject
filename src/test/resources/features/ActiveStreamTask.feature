Feature: As a user, I should be able to assign tasks by clicking on Task tab under Active Stream

  Background: User log in and is on the <Active Stream> home page

  @test

  Scenario: 1. "High Priority" task functionality
    Given user login and is on the <Active Stream> home page
    When User clicks on <Task> button
    * User clicks <High Priority> dropdown box
    Then User see fire icon colored

  Scenario: 2. Visual Editor functionality
    When User clicks on <Task> button
    * User clicks on the letter <A> in the bottom of the message box
    Then The editor text-bar on the top of the message box is displayed

  Scenario: 3. Uploading file functionality
    When User clicks on <Task> button
    Then User writes in <Thing to do> box text "Uploading file testing"
    * User clicks on <Upload files> icon and upload <TeamTestCases> file  and <LoginVyTrack> picture from local disks
   # BUG * User clicks on "Download from external drive" hypertexts
    Then User clicks the <Select document> button and upload a file from <Bitrix>
   # BUG * User select a file and clicks "Create using MS Office online" button
    * User clicks <Send> button
    * User clicks on <Task> button on menu bar
    Then User see the "Uploading file testing" in <My Tasks> table


  Scenario: 4. Quoting text functionality
    When User clicks on <Task> button
    And User writes in <Thing to do> box text "Quoting text testing"
    * User clicks <Quote text> icon
    * User writes a text "This is quoting text test" in <message box> empty box
    * User clicks <Send> button
    * User clicks on <Task> button on menu bar
    Then User see the the "Quote text" in <My Tasks> table


  Scenario: 5. Add mention functionality
    When User clicks on <Task> button
    And User writes in <Thing to do> box text "Add mention testing"
    * User clicks on <Add mention> button
    * User clicks on <Employees and departments>
    * User clicks on given email and chooses it
    * User clicks <Send> button
    * User clicks on <Task> button on menu bar
    Then User see the the "Add mention" in <My Tasks> table


  Scenario Outline: 6. Attach link functionality
    When User clicks on <Task> button
    And User writes in <Thing to do> box text "Attach link testing"
    And User clicks on link icon
    And User writes the "<Text link>" and pastes "<URL link>" and save it
    * User clicks <Send> button
    * User clicks on <Task> button on menu bar
    Then User see the the "Attach link testing" in <My Tasks> table

    Examples:
      | Text link                             | URL link                                    |
      | NASA Live: Official Stream of NASA TV | https://www.youtube.com/watch?v=21X5lGlDOfg |


  Scenario: 7. Checklist functionality

    When User clicks on <Task> button
    And User writes in <Thing to do> box text "Checklist testing"
    And User clicks on <Checklist> icon
    And User writes "<text>" in <Checklist>
    * User clicks <Send> button
    * User clicks on <Task> button on menu bar
    Then User see the the "Checklist testing" in <My Tasks> table




























