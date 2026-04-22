class Solution:
    def twoEditWords(self, queries, dictionary):
        """
        :type queries: List[str]
        :type dictionary: List[str]
        :rtype: List[str]
        """
        ans = []
        
        # 1. Iterate through each word in the queries list
        for q in queries:
            # 2. Check it against every word in the dictionary
            for d in dictionary:
                diffs = 0
                
                # 3. Compare character by character (Hamming Distance)
                # Since all words are the same length, we can use range(len(q))
                for i in range(len(q)):
                    if q[i] != d[i]:
                        diffs += 1
                    
                    # 4. Optimization: if we already exceeded 2 edits, 
                    # stop checking this dictionary word.
                    if diffs > 2:
                        break
                
                # 5. If we found a match within 2 edits, 
                # add the query word and stop checking the rest of the dictionary.
                if diffs <= 2:
                    ans.append(q)
                    break
                    
        return ans