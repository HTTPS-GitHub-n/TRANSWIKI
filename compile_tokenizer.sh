#!/bin/sh
if ! [ -f classes ];
then
   mkdir classes
fi
javac -cp .:pdfbox -d classes ir/Tokenizer.java ir/TokenTest.java ir/Index.java ir/Indexer.java ir/HashedIndex.java ir/Query.java ir/PostingsList.java ir/PostingsEntry.java
