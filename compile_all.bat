if not exist classes mkdir classes
javac -cp .;pdfbox -d classes ir\Tokenizer.java ir\TokenTest.java ir\Index.java ir\Indexer.java ir\HashedIndex.java ir\Query.java ir\PostingsList.java ir\PostingsEntry.java ir\SearchGUI.java
