The Employee table holds all employees including their managers. Every employee has an Id, and there is also a column for the manager Id.

t
+----+-------+--------+-----------+
| Id | Name  | Salary | ManagerId |
+----+-------+--------+-----------+
| 1  | Joe   | 70000  | 3         |
| 2  | Henry | 80000  | 4         |
| 3  | Sam   | 60000  | NULL      |
| 4  | Max   | 90000  | NULL      |
+----+-------+--------+-----------+

s
+----+-------+--------+-----------+
| Id | Name  | Salary | ManagerId |
+----+-------+--------+-----------+
| 1  | Joe   | 70000  | 3         |
| 2  | Henry | 80000  | 4         |
| 3  | Sam   | 60000  | NULL      |
| 4  | Max   | 90000  | NULL      |
+----+-------+--------+-----------+


Given the Employee table, write a SQL query that finds out employees who earn more than their managers. For the above table,
Joe is the only employee who earns more than his manager.

+----------+
| Employee |
+----------+
| Joe      |
+----------+

# select Name as Employee from Employee as t where ManagerId is not null and Salary > (select Salary from Employee as s where t.Mana    gerId=s.Id);
    is equal to the following
# select t.Name as Employee from employee as t,employee as s where t.salary > s.salary and t.managerid = s.id;
+------+-------+--------+-----------+------+-------+--------+-----------+
| id   | name  | salary | managerid | id   | name  | salary | managerid |
+------+-------+--------+-----------+------+-------+--------+-----------+
|    1 | joe   |  70000 |         3 |    1 | joe   |  70000 |         3 |
|    2 | henry |  80000 |         4 |    1 | joe   |  70000 |         3 |
|    3 | sam   |  60000 |      NULL |    1 | joe   |  70000 |         3 |
|    4 | max   |  90000 |      NULL |    1 | joe   |  70000 |         3 |
|    1 | joe   |  70000 |         3 |    2 | henry |  80000 |         4 |
|    2 | henry |  80000 |         4 |    2 | henry |  80000 |         4 |
|    3 | sam   |  60000 |      NULL |    2 | henry |  80000 |         4 |
|    4 | max   |  90000 |      NULL |    2 | henry |  80000 |         4 |
|    1 | joe   |  70000 |         3 |    3 | sam   |  60000 |      NULL |
|    2 | henry |  80000 |         4 |    3 | sam   |  60000 |      NULL |
|    3 | sam   |  60000 |      NULL |    3 | sam   |  60000 |      NULL |
|    4 | max   |  90000 |      NULL |    3 | sam   |  60000 |      NULL |
|    1 | joe   |  70000 |         3 |    4 | max   |  90000 |      NULL |
|    2 | henry |  80000 |         4 |    4 | max   |  90000 |      NULL |
|    3 | sam   |  60000 |      NULL |    4 | max   |  90000 |      NULL |
|    4 | max   |  90000 |      NULL |    4 | max   |  90000 |      NULL |
+------+-------+--------+-----------+------+-------+--------+-----------+