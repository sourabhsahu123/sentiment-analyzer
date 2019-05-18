
#install.packages('stringr')
#install.packages('twitteR')
#install.packages("Rserve")
library(twitteR)
library(ROAuth)
library(stringr)
library(wordcloud)
library(tm)
library(plyr)
library(Rserve)
library(syuzhet)
Rserve()
consumer_key<-"tW05QBzQNLxpNOlZUL2p25xM4"
consumer_secret <- "9XnHkzB0qb06pBtoFw3ADKoMibSCmAc1naMbuvmd6XJ1WnRiu1"
access_token <- "1039522235256459264-7JXsagtfvki5wwEekQygMZjdEUnGHm"
access_secret <- "V5gQAELRY0vTIsBTgTHevhHFlBQoYgm40lpbHWUjRFB7e"

getMyTwitterScore<-function(x)
{
  
  
  #set up to authenticate
  setup_twitter_oauth(consumer_key ,consumer_secret,access_token ,access_secret)
    tweets <-twitteR::searchTwitter(x, n=100,lang='en')
  tweets.df <- twListToDF(tweets)
  tweets.df2<-gsub("http.*","",tweets.df$text)
  tweets.df2<-gsub("https.*","",tweets.df2)
 
  #strip retweets
  #twitteR::strip_retweets(tweets)
  word.df<-as.vector(tweets.df2)
  emotion.df<-get_nrc_sentiment(word.df)
  emotion.df2<-cbind(tweets.df2,emotion.df)
  sent.value<-get_sentiment(word.df)
  positive.tweets<-word.df[sent.value>0]
  negative.tweets<-word.df[sent.value<0]
  neutral.tweets<-word.df[sent.value==0]
  sentiment_category<-ifelse(sent.value<0,"negative",ifelse(sent.value>0,"positive","neutral"))
  sentiment_category_final<-cbind(tweets.df2,sentiment_category,sent.value)
  table(sentiment_category)
  xvalue.df<-as.data.frame(table(sentiment_category))
  write.csv(sentiment_category_final,paste("D:/",x,".csv"))
  score<-paste(xvalue.df[1,2],"-",xvalue.df[2,2],"-",xvalue.df[3,2])
   # as.numeric(xvalue.df[1,2])*-1+
    #as.numeric(xvalue.df[2,2])*0+
   # as.numeric(xvalue.df[3,2])*+1
 # x<score
    
    return (toString(score))
    #(as.numeric(score))
    
  
}
#getMyTwitterScore("#SwachhBharatDiwas")

