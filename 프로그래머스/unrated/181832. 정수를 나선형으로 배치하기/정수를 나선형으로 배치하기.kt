class Solution {
    fun solution(n: Int): Array<IntArray> {
        val dx = intArrayOf(0, 1, 0, -1)
        val dy = intArrayOf(1, 0, -1, 0)
        val answer = Array(n) { IntArray(n) { 0 } }
        var d = 0
        var num = 1
        var i = 0
        var j = 0

        answer[i][j] = num++

        while (true) {
            if (num == n * n + 1)
                break
            val x = i + dx[d]
            val y = j + dy[d]
            if (x < 0 || y < 0 || x >= n || y >= n || answer[x][y] != 0) {
                d = (d + 1) % 4
                continue
            }
            answer[x][y] = num++
            i = x
            j = y
        }
        return answer
    }
}