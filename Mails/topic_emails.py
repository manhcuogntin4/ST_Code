
import numpy as np
import pandas as pd
import matplotlib.pyplot as plt

from sklearn.feature_extraction.text import TfidfVectorizer, ENGLISH_STOP_WORDS
from sklearn.pipeline import make_pipeline
from sklearn.decomposition import PCA
from sklearn.cluster import KMeans, MiniBatchKMeans
from sklearn.manifold import TSNE
from sklearn.decomposition import TruncatedSVD 
from sklearn.preprocessing import normalize 

from helpers import * 


from nltk.tokenize import RegexpTokenizer
from stop_words import get_stop_words
from nltk.stem.porter import PorterStemmer
from gensim import corpora, models
import gensim
import nltk
from nltk.tokenize import word_tokenize
from nltk.tag import pos_tag



from textblob import TextBlob


def fn_preprocess(art):
    art = nltk.word_tokenize(art)
    art = nltk.pos_tag(art)
    return art





emails = pd.read_csv('split_emails.csv')
# Lets create a new frame with the data we need.
email_df = pd.DataFrame(parse_into_emails(emails.message))

# Drop emails with empty body, to or from_ columns. 
email_df.drop(email_df.query("body == '' | to == '' | from_ == ''").index, inplace=True)

print list(email_df)
print email_df["from_"][:10]

tokenizer = RegexpTokenizer(r'\w+')

# create English stop words list
en_stop = get_stop_words('en')

# Create p_stemmer of class PorterStemmer
p_stemmer = PorterStemmer()
    


# compile sample documents into a list
doc_set = email_df["body"][:100]
doc_set.to_csv("test.csv")
doc_set_dic=[]
for i in doc_set:
	a=TextBlob(i).noun_phrases
	for e in a:
		for k in e.split():
			doc_set_dic.append(k)


dic_1=[]
for j in doc_set:
	art_processed = fn_preprocess(j)
	for i in art_processed:
		if i[1]=='NNP' or i[1]=='NNPS':
			dic_1.append(i[0].lower())


print dic_1
#doc_set_dic=[TextBlob(X).noun_phrases for X in doc_set ]
#doc_set_dic=set([i for i in doc_set_dic])
#doc_set = TextBlob(doc_set.noun_phrases)
#print("dic:",doc_set_dic)
print doc_set[1]


#doc = nlp('European authorities fined Google a record $5.1 billion on Wednesday for abusing its power in the mobile phone market and ordered the company to alter its practices')

# print([(X.text, X.label_) for X in doc.ents])


# list for tokenized documents in loop
texts = []

en_stop=set(en_stop).union(["will","forward"])

# loop through document list
for i in doc_set:
    
    # clean and tokenize document string
    raw = i.lower()
    tokens = tokenizer.tokenize(raw)

    # remove stop words from tokens
    stopped_tokens = [i for i in tokens if not i in en_stop and i in doc_set_dic and i not in dic_1]
    
    # stem tokens
    stemmed_tokens = [p_stemmer.stem(i) for i in stopped_tokens]

    stemmed_tokens =[i for i in stemmed_tokens if not i in en_stop]
    
    # add tokens to list
    texts.append(stemmed_tokens)

# turn our tokenized documents into a id <-> term dictionary
dictionary = corpora.Dictionary(texts)
    
# convert tokenized documents into a document-term matrix
corpus = [dictionary.doc2bow(text) for text in texts]

# generate LDA model
ldamodel = gensim.models.ldamodel.LdaModel(corpus, num_topics=3, id2word = dictionary, passes=20)

#from gensim.test.utils import datapath
#temp_file = datapath("data/model/emails_topic")
ldamodel.save("data/model/emails_topic.model")
dictionary.save("data/model/emails_topic.dict")



print(ldamodel.print_topics(num_topics=3, num_words=5))
