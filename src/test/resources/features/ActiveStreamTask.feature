Feature: As a user, I should be able to assign tasks by clicking on Task tab under Active Stream

  Background: User log in and is on the <Active Stream> home page
    Given user login and is on the <Active Stream> home page


  Scenario: 1. "High Priority" task functionality
    When User clicks on <Task> button
    * User clicks <High Priority> dropdown box
    Then User see fire icon colored

  Scenario: 2. Visual Editor functionality
    When User clicks on <Task> button
    * User clicks on the letter <A> in the bottom of the message box
    Then The editor text-bar on the top of the message box is displayed

  Scenario: 3. Uploading file functionality
  from local disks, download from external drive, select documents from bixtrix24,
  and create files to upload.
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

  @test
  Scenario: 5. Add mention functionality
    When User clicks on <Task> button
    And User writes in <Thing to do> box text "Add mention"
    * User clicks on <Add mention> button
    * User clicks on <Employees and departments>
    And User clicks on given email and chooses it
    * User clicks <Send> button
    * User clicks on <Task> button on menu bar
    Then User see the the "Add mention" in <My Tasks> table




















