Feature: Ninjaskills
    Scenario: Kill a ninja
        Given the ninja "Shredder" exists
        When the ninja gets killed by SHURIKIEN
        Then "Shredder" should be dead