class Solution {
public:
    void dfs(vector<vector<int>>& image, int r, int c, int original, int color) {
        int m = image.size();
        int n = image[0].size();

        if (r < 0 || r >= m || c < 0 || c >= n)
            return;

        if (image[r][c] != original)
            return;

        image[r][c] = color;

        dfs(image, r - 1, c, original, color);
        dfs(image, r + 1, c, original, color);
        dfs(image, r, c - 1, original, color);
        dfs(image, r, c + 1, original, color);
    }

    vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc, int color) {
        int original = image[sr][sc];

        if (original == color)
            return image;

        dfs(image, sr, sc, original, color);

        return image;
    }
};