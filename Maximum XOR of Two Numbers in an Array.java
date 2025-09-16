class Solution {
    private static class TrieNode {
        TrieNode[] children = new TrieNode[2];
    }

    public int findMaximumXOR(int[] nums) {
        TrieNode root = new TrieNode();
        int maxXor = 0;

        for (int num : nums) {
            TrieNode node = root;
            TrieNode xorNode = root;
            int currentXor = 0;

            for (int i = 31; i >= 0; i--) {
                int bit = (num >>> i) & 1;

                if (node.children[bit] == null) {
                    node.children[bit] = new TrieNode();
                }
                node = node.children[bit];

                int toggledBit = 1 - bit;
                if (xorNode.children[toggledBit] != null) {
                    currentXor += (1 << i);
                    xorNode = xorNode.children[toggledBit];
                } else {
                    xorNode = xorNode.children[bit];
                }
            }

            maxXor = Math.max(maxXor, currentXor);
        }

        return maxXor;
    }
}
