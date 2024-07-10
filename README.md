# DD2476-Search-Engines-and-Information-Retrieval-Systems
Implementation of a SpellChecker using the Levenshtein distance, for integration to the course's java skeleton. If the user's query to the search engine doens't exist in the index, the SpellChecker replaces the query with another that has the minimum editing distance with the original and exists in the index. 

## Instructions to compile and run in Linux
Unfortunately, since this skeleton is used by the course, this repository does not contain the solution. However, in case someone has completed the course, he/she is welcome to clone this repository and substitute the files `ir/HashedIndex.java`, `ir/PostingsEntry.java`, `ir/PostingsList.java` and `ir/Query.java` with the completed ones and give it a try! The scripts for compiling and running the search engine (`compile_all.sh`, `run_search_engine.sh`) in Linux, have been edited to integrate the Spellchecker. For use in Windows, edit the `compile_all.bat` and `run_search_engine.bat` accordingly.

1) Unzip the daviswiki.zip file in the current directory
2) `./compile_all.sh`
3) `./run_search_engine.sh`
4) Try out a query!

#### BUGS
Feel free to report any bugs that you may discover!
