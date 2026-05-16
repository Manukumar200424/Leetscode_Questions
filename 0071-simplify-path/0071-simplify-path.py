class Solution:
    def simplifyPath(self, path):
        stack = []

        # Split path by '/'
        parts = path.split('/')

        for part in parts:

            # Ignore empty and current directory
            if part == '' or part == '.':
                continue

            # Go back to parent directory
            elif part == '..':
                if stack:
                    stack.pop()

            # Valid directory name
            else:
                stack.append(part)

        # Build simplified path
        return '/' + '/'.join(stack)