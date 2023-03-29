import json

import requests


response_API = requests.get('https://datausa.io/api/data?drilldowns=Nation&measures=Population')

resp = response_API.json()
print(json.dumps(resp,indent=3))
print(resp.get('data'))
resp_dict = resp.get('data')

print("Length of dict")
print(len(resp_dict))

# for getting difference between population years
populationDiffList=[]
for i in range(0,len(resp_dict)):
    if i+1 <len(resp_dict):
        print(resp_dict[i]['Population']-resp_dict[i+1]['Population'])
        populationDiffList.append(resp_dict[i]['Population']-resp_dict[i+1]['Population'])

print("pupulation difference")
print(populationDiffList)

#percent population growth calculator
populationPercent=[]
for i in range(0,len(resp_dict)):
    if i+1 <len(resp_dict):
        #population growth = (Finalvalue - InitialValue)/ InitialValue * 100
        print(((resp_dict[i]['Population']-resp_dict[i+1]['Population'])/resp_dict[i+1]['Population'])*100)
        percent = ((resp_dict[i]['Population']-resp_dict[i+1]['Population'])/resp_dict[i+1]['Population'])*100
        populationPercent.append(percent)

print("pupulation percentage")
print(populationPercent)

print("Peak population growth percent")
print(max(populationPercent))

print("lowest population increase percent")
print(min(populationPercent))

source = resp.get('source')[0]
print (source)
print ("sourcename")

#for accessing dictionary from list
my_list = []
for i in source.values():
    my_list.append(i)
print (my_list)
print(my_list[1])

sourceDict = my_list[1]['source_name']
print(sourceDict)
print("According to {}, in 2013-2020 years from 2013 to 2020, peak population growth was {} in 2014 and the lowestpopulation increase was {}% in 2019.)".format(sourceDict,max(populationPercent), min(populationPercent)))