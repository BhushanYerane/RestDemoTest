Feature: validattion for bookstore data

Scenario: Test-1 Git Pocket Guide is presetn in response json
Given Hit the bookstore api 
Then validate as status code 
Then validate Git Pocket Guide title present
Then validate Learning JavaScript Design Patterns title present

Scenario: Test-2 title is presetn in response json
Given Hit the bookstore api 
Then validate as status code 
Then validate "Git Pocket Guide" at jsonpath "books[0].title" title present
Then validate "Learning JavaScript Design Patterns" at jsonpath "books[1].title" title present
Then validate "Designing Evolvable Web APIs with ASP.NET" at jsonpath "books[2].title" title present

Scenario: Test-3 pagenumber presetn in response json
Given Hit the bookstore api 
Then validate as status code 
Then validate "234" at jsonpath "books[0].pages" pageNumbers present
Then validate "254" at jsonpath "books[1].pages" pageNumbers present

Scenario: Test-4 Validate data in json response
Given Hit the bookstore api 
Then validate as status code 
Then validate "Git Pocket Guide" at jsonpath "books[0].title" present
Then validate "A Working Introduction" at jsonpath "books[0].subTitle" present
Then validate "Richard E. Silverman" at jsonpath "books[0].author" present


