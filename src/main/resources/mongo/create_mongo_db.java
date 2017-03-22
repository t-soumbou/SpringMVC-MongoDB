


//Author

db.Author.createIndex( { "id": 1 }, { unique: true }  );
//Badge

db.Badge.createIndex( { "badgeNumber": 1 }, { unique: true }  );
//Book

db.Book.createIndex( { "id": 1 }, { unique: true }  );
//BookOrder

db.BookOrder.createIndex( { "id": 1 }, { unique: true }  );
//BookOrderItem

db.BookOrderItem.createIndex( { "bookOrderId": 1,  "bookId": 1  }, { unique: true }  );
//Country

db.Country.createIndex( { "code": 1 }, { unique: true }  );
//Customer

db.Customer.createIndex( { "code": 1 }, { unique: true }  );
//Employee

db.Employee.createIndex( { "code": 1 }, { unique: true }  );
//EmployeeGroup

db.EmployeeGroup.createIndex( { "employeeCode": 1,  "groupId": 1  }, { unique: true }  );
//Publisher

db.Publisher.createIndex( { "code": 1 }, { unique: true }  );
//Review

db.Review.createIndex( { "customerCode": 1,  "bookId": 1  }, { unique: true }  );
//Shop

db.Shop.createIndex( { "code": 1 }, { unique: true }  );
//Synopsis

db.Synopsis.createIndex( { "bookId": 1 }, { unique: true }  );
//Workgroup

db.Workgroup.createIndex( { "id": 1 }, { unique: true }  );



















/*
//Author

Document doc = new Document ("id", 1);
createIndex(doc, new IndexOptions().unique(true));

//Badge

Document doc = new Document ("badgeNumber", 1);
createIndex(doc, new IndexOptions().unique(true));

//Book

Document doc = new Document ("id", 1);
createIndex(doc, new IndexOptions().unique(true));

//BookOrder

Document doc = new Document ("id", 1);
createIndex(doc, new IndexOptions().unique(true));

//BookOrderItem

Document doc = new Document ()
.append("bookOrderId", 1)
.append("bookId", 1)
;
createIndex(doc, new IndexOptions().unique(true));

//Country

Document doc = new Document ("code", 1);
createIndex(doc, new IndexOptions().unique(true));

//Customer

Document doc = new Document ("code", 1);
createIndex(doc, new IndexOptions().unique(true));

//Employee

Document doc = new Document ("code", 1);
createIndex(doc, new IndexOptions().unique(true));

//EmployeeGroup

Document doc = new Document ()
.append("employeeCode", 1)
.append("groupId", 1)
;
createIndex(doc, new IndexOptions().unique(true));

//Publisher

Document doc = new Document ("code", 1);
createIndex(doc, new IndexOptions().unique(true));

//Review

Document doc = new Document ()
.append("customerCode", 1)
.append("bookId", 1)
;
createIndex(doc, new IndexOptions().unique(true));

//Shop

Document doc = new Document ("code", 1);
createIndex(doc, new IndexOptions().unique(true));

//Synopsis

Document doc = new Document ("bookId", 1);
createIndex(doc, new IndexOptions().unique(true));

//Workgroup

Document doc = new Document ("id", 1);
createIndex(doc, new IndexOptions().unique(true));

*/