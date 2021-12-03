from django.shortcuts import render
from django.http import HttpResponse
from django.conf import settings
import json
from django.http import JsonResponse
from rest_framework.views import APIView
from rest_framework.response import Response

conn = settings.DATABASE_CONN


def index(request):


      try:
          query1 = "select snapshot_date,offer_code, count(*) from arcadia_hadoop_df.df_table_name where date not like '%2018%' group by date,code order by date,code"
          cur = conn.cursor()
          cur.execute(query1)
          data = cur.fetchmany(1000)
          print(query1)
          return render(request, 'webapp/home.html',{'data':data})

      except Exception as e:
          return(str(e))
