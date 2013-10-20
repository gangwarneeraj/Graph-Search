#!/usr/bin/python
import MySQLdb as mdb

con = mdb.connect('localhost','root','root','testdb')
cur = con.cursor()
with con:
 cur.execute("DROP TABLE IF EXISTS Actresses")
 cur.execute("CREATE TABLE Actresses(Name VARCHAR(50),Movie VARCHAR(100),Year INT(4),Role VARCHAR(30))")
 count =0
 
 with open('../actresses.list') as inputfile:
    for line in inputfile:
        count = count+1
        if count > 100000:
            break
        elif count > 241:
          
          current = line.split("\t")
          if current[0] == '' :
            line = line.strip()
            current = line.split("\t")
            current.insert(0,'')
          #print current
          
          if len(current)>1:
              if current[1] == '':
                current.pop(1)
           #   print current
          
              if current[0] != '':
                current_actor = current[0]
              if len(current[1].split("\t"))>1:
                    current_movie = current[1].split("\t")[1]
              else: 
                    current_movie = current[1].split("\t")[0]

              try:
                  current_year = current_movie.split('(',1)[1].split(')')[0]
              except:
                  current_year = " "
              
              try:
                  current_role = current_movie.split('[',1)[1].split(']')[0]
              except :
                  current_role = "Not Available"

#              print current_actor
              current_movie = current_movie.split('(',1)[0]
            # print cirrent_movie 
            #  print current_year
            #  print current_role
            #  print current_actor

              try:
                  print count
                  print current_movie
                  cur.execute("INSERT INTO Actresses(Name,Movie,Year,Role) VALUES (%s,%s,%s,%s)",(current_actor,current_movie,int(current_year),current_role))
              except:
                  continue

