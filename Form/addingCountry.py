import mysql.connector
import csv

mydb = mysql.connector.connect(
    host="localhost",
    user="root",
    password="Amish.com234",
    database="formjava"
)

cursor = mydb.cursor()
file = open('./country-code-new.csv')
csvreader = csv.DictReader(file)


# try:
for a in csvreader:
    print (a)
    sql = "INSERT INTO countryId VALUES (%s, %s)"
    val = (a['countryCode'], a['Country'])
    cursor.execute(sql, val)
# except mysql.connector.errors.DataError:
#     print (a)


mydb.commit()

