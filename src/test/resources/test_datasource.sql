INSERT INTO "DEPARTMENTS" (id, name, parent) VALUES (1, 'Logistics', null);
INSERT INTO "DEPARTMENTS" (id, name, parent) VALUES (2, 'Accounting', null);
INSERT INTO "DEPARTMENTS" (id, name, parent) VALUES (3, 'Sales', null);
INSERT INTO "DEPARTMENTS" (id, name, parent) VALUES (4, 'Accounting Support', 2);
INSERT INTO "DEPARTMENTS" (id, name, parent) VALUES (5, 'Accounting Support 2', 2);


INSERT INTO "LOGENTRY" (id, entryStamp, rowId, tableName, employeeId, operationType) 
VALUES (1, '2012-05-15 13:12:45', 1, 'DEPARTMENTS', 1, 'CREATE');
INSERT INTO "LOGENTRY" (id, entryStamp, rowId, tableName, employeeId, operationType) 
VALUES (2, '2012-05-16 22:10:01', 2, 'DEPARTMENTS', 1, 'CREATE');
INSERT INTO "LOGENTRY" (id, entryStamp, rowId, tableName, employeeId, operationType) 
VALUES (3, '2012-05-17 09:55:11', 3, 'DEPARTMENTS', 2, 'CREATE');
INSERT INTO "LOGENTRY" (id, entryStamp, rowId, tableName, employeeId, operationType) 
VALUES (4, '2012-05-22 01:12:09', 4, 'DEPARTMENTS', 3, 'CREATE');
INSERT INTO "LOGENTRY" (id, entryStamp, rowId, tableName, employeeId, operationType) 
VALUES (5, '2012-05-28 11:00:15', 4, 'DEPARTMENTS', 3, 'UPDATE');