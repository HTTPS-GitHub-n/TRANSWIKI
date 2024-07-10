/*
 *	Spell checker implementation using the Levenhstein distance algorithm.
 *
 *	First version: Alexandros Krontiris, 2017
 */

package ir;

import java.util.Iterator;

public class SpellChecker {

	private Query query;
	private int queryType;
	private static Indexer indexer;
	private static final String WHITESPACE = " ";

	public SpellChecker(Query _query, Indexer _indexer) {
		this.query = _query;
		this.indexer = _indexer;
	}

	public String getMatch() {
		StringBuilder strBuild = new StringBuilder();
		String term = null;
		String match = null;
		for (int i = 0; i < query.terms.size(); i++) {
			term = query.terms.get(i);
			if (indexer.index.getPostings(term) == null) {
				match = scanIndex(term);
			}
			else {
				match = term;
			}
			strBuild.append(match);
			strBuild.append(WHITESPACE);
		}
		match = strBuild.toString();
		return match;
	}

	private String scanIndex(String misspelled) {
		String closestMatch = null;
		String candidate = null;
		Iterator<String> itr = this.indexer.index.getDictionary();
		int editDistance = misspelled.length();
		int postingsListSize = 0;
		while (itr.hasNext()) {
			candidate = itr.next();
			int candidate_editDistance = Levenshtein(misspelled, candidate);
			int candidate_postingsListSize = this.indexer.index.getPostings(candidate).size();
			if (candidate_editDistance < editDistance) {
				closestMatch = candidate;
				postingsListSize = candidate_postingsListSize;
				editDistance = candidate_editDistance;
			}
			else if (candidate_editDistance == editDistance && candidate_postingsListSize > postingsListSize) {
				closestMatch = candidate;
				postingsListSize = candidate_postingsListSize;
				editDistance = candidate_editDistance;
			}
			
		}
		return closestMatch;
	}
		
	private int Levenshtein(String a, String b) {
        a = a.toLowerCase();
        b = b.toLowerCase();
        int [] costs = new int [b.length() + 1]; 
        for (int j = 0; j < costs.length; j++) {
            costs[j] = j;
		}
        for (int i = 1; i <= a.length(); i++) {
            costs[0] = i;
            int nw = i - 1;
            for (int j = 1; j <= b.length(); j++) {
                int cj = Math.min(1 + Math.min(costs[j], costs[j - 1]), a.charAt(i - 1) == b.charAt(j - 1) ? nw : nw + 1);
                nw = costs[j];
                costs[j] = cj; 
            }   
        }   
		return costs[b.length()];
    } 
}
