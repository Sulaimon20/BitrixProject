@test
Feature: As a user, I should be able to assign tasks by clicking on Task tab under Active Stream

  Background: User log in and is on the <Active Stream> home page


  Scenario: 1. "High Priority" task functionality
    Given user login and is on the <Active Stream> home page
    When User clicks on <Task> button
    * User writes in <Thing to do> box text "High priority task testing"
    * User clicks <High Priority> dropdown box
    Then User see fire icon colored
    * User clicks <Send> button
    * User clicks on <Task> button on menu bar
    Then User see the "High priority task testing" in <My Tasks> table

  Scenario: 2. Visual Editor functionality
    When User in is Hope page
    * User clicks on <Task> button
    When User writes in <Thing to do> box text "Visual Editor testing"
    * User clicks on the letter <A> in the bottom of the message box
    Then The editor text-bar on the top of the message box is displayed
    * User clicks <Send> button
    * User clicks on <Task> button on menu bar
    Then User see the "Visual Editor testing" in <My Tasks> table

  Scenario: 3. Uploading file functionality
    When User in is Hope page
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
    When User in is Hope page
    When User clicks on <Task> button
    And User writes in <Thing to do> box text "Quoting text testing"
    * User clicks <Quote text> icon
    * User writes a text "This is quoting text test" in <message box> empty box
    * User clicks <Send> button
    * User clicks on <Task> button on menu bar
    Then User see the the "Quote text" in <My Tasks> table

  Scenario: 5. Add mention functionality
    When User in is Hope page
    When User clicks on <Task> button
    And User writes in <Thing to do> box text "Add mention testing"
    * User clicks on <Add mention> button
    * User clicks on given email and chooses it
    * User clicks <Send> button
    * User clicks on <Task> button on menu bar
    Then User see the the "Add mention" in <My Tasks> table

  Scenario Outline: 6. Attach link functionality
    When User in is Hope page
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
    When User in is Hope page
    When User clicks on <Task> button
    And User writes in <Thing to do> box text "Checklist testing"
    And User clicks on <Checklist> icon
    And User writes "<text>" in <Checklist>
    * User clicks <Send> button
    * User clicks on <Task> button on menu bar
    Then User see the the "Checklist testing" in <My Tasks> table

  Scenario: 8. Assign the tasks to employees (Add more) functionality
    When User in is Hope page
    * User clicks on <Task> button
    * User writes in <Thing to do> box text "Assign the tasks to employees testing"
    * User clicks on <Add more>
    And User clicks on assignee's emails and chooses it
    * User clicks <Send> button
    * User clicks on <Task> button on menu bar
    Then User see the the "Assign the tasks to employees testing" in <My Tasks> table

  Scenario Outline: 9.  Deadline and Time Planning functionality
    When User in is Hope page
    And User clicks on <Task> button
    * User writes in <Thing to do> box text "Deadline and Time Planning testing"
    * User clicks on <Deadline> dropbox
    * User clicks on "<month>", "<year>", "<date>", "<hour>", "<minute>" and "<pm_am>"
    * User clicks on Select button
    * User clicks on <Time planning> and <Start task on>
    * User clicks <Select> button
    * User click "<options>" and writes the time "<duration>"
    * User clicks <Send> button
    * User clicks on <Task> button on menu bar
    Then User see the the "Checklist testing" in <My Tasks> table

    Examples:
      | year | month  | date | hour | minute | pm_am | options | duration |
      | 2022 | August | 20   | 3    | 15     | pm    | minutes | 30       |

  Scenario: 10. More to specify the task details functionality
    When User in is Hope page
    * User clicks on <Task> button
    * User writes in <Thing to do> box text "More option to specify the task details testing"
    * User clicks on <More>
    * User clicks Time tracking and defines time "1" as hour and "15" minute
    * User add reminder and activate repeate task
    * User clicks <Send> button
    * User clicks on <Task> button on menu bar
    Then User see the the "Assign the tasks to employees testing" in <My Tasks> table



























