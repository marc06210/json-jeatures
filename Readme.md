# json features



The code here demonstrate how we can monitor some biz services without injecting code into our biz logic.



## deserialize string or list of string for same element

You receive json data where the same element can be represented through different data type. For example, one element is a list of string but there is only one element your json provider returns a single string.

Check the **MyObject** and **MyObjectTest** classes to see how to handle such situation.