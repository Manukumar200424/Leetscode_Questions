# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def pathSum(self, root, targetSum):
        result = []

        def dfs(node, curr_sum, path):
            if not node:
                return

            path.append(node.val)
            curr_sum += node.val

            if not node.left and not node.right:
                if curr_sum == targetSum:
                    result.append(path[:])
            else:
                dfs(node.left, curr_sum, path)
                dfs(node.right, curr_sum, path)

            path.pop()

        dfs(root, 0, [])
        return result
        