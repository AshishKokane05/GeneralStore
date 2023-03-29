import requests
#import json
import pandas as pd

response_API = requests.get('https://datausa.io/api/data?drilldowns=Nation&measures=Population')

data = response_API.text

import ast
res = ast.literal_eval(data)
print("res")
print(res)
res1 = res['data']
df = pd.DataFrame(res1)
# for sum of population of all year
#df['Total_Population'] = sum(df['Population'])
# for finding out the percentage

df['population_diff'] = df['Population']-df['Population'].shift(-1)
print(df)



preakGrowthPercent = df['population_diff'].max()
print(preakGrowthPercent)

df['Populatopn_perc'] = (df['population_diff']/df['Population'].shift(-1))*100
print(df['Populatopn_perc'])

print(df['Populatopn_perc'].max())
print(df['Populatopn_perc'].min())


#preakGrowthPercent = df['population(%)'].max()
#print(preakGrowthPercent)
#lowestPercent = df['population(%)'].min()
#print(lowestPercent)

#df['Population%Diff']=  df['population(%)'] - df['population(%)'].shift(-1)

#minPopulationdiff = df['Population%Diff'].min()*100
#print(df['Population%Diff'])
#print(df)

print("According to Census Bureau, in 2013-2020 years from 2013 to 2020, peak population growth was {} in 2014 and the lowestpopulation increase was {}% in 2019.)".format(df['Populatopn_perc'].max(), df['Populatopn_perc'].min()))


############################################################################################

# data = {}

# for url in url_validation.url:
#         r = requests.get(url)
#         result_df = pd.DataFrame(columns=['url','links'])
#         if r.status_code == 200:
#             data[url] = r.text