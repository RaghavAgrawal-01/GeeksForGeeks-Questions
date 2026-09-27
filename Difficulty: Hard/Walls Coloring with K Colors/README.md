<h2><a href="https://www.geeksforgeeks.org/problems/walls-coloring-ii--170647/1">Walls Coloring with K Colors</a></h2><h3>Difficulty Level : Difficulty: Hard</h3><hr><div class="problems_problem_content__Xm_eO" style="--text-color: var(--problem-text-color);"><p><span style="font-size: 18px;">Given <strong>n</strong> walls arranged in a row, and each wall must be painted using one of the <strong>k</strong> available colors. The cost of painting i-th</span><strong style="font-size: 18px;"> </strong><span style="font-size: 18px;">wall </span><span style="font-size: 18px;">with<strong>&nbsp;</strong>j-th</span><strong style="font-size: 18px;"> </strong><span style="font-size: 18px;">color </span><span style="font-size: 18px;">is given by </span><strong style="font-size: 18px;">costs[i][j]</strong><span style="font-size: 18px;">. </span></p>
<p><span style="font-size: 18px;">Find the </span><span style="font-size: 18px;">minimum total cost</span><span style="font-size: 18px;"> required to paint all the walls in such a way that </span><span style="font-size: 18px;">no two adjacent walls</span><span style="font-size: 18px;"> share the same color. </span></p>
<p><span style="font-size: 18px;">If it is impossible to paint the walls under this condition, return </span><span style="font-size: 18px;">-1</span><span style="font-size: 18px;">.</span></p>
<p><span style="font-size: 18px;"><strong>Examples:</strong></span></p>
<pre><span style="font-size: 18px;"><strong>Input: </strong>n = 4, k = 3, costs[][] = [[1, 5, 7], [5, 8, 4], [3, 2, 9], [1, 2, 4]] <strong><br></strong><img src="https://media.geeksforgeeks.org/img-practice/prod/addEditProblem/713979/Web/Other/blobid2_1786002255.png" width="159" height="133"><strong><br>Output: </strong>8    
<strong>Explanation:</strong>
Paint wall 0 with color 0. Cost = 1
Paint wall 1 with color 2. Cost = 4
Paint wall 2 with color 1. Cost = 2
Paint wall 3 with color 0. Cost = 1
Total Cost = 1 + 4 + 2 + 1 = 8<br></span></pre>
<pre><span style="font-size: 18px;"><strong>Input: </strong>n = 5, k = 1, costs[][] = [[5], [4], [9], [2], [1]]
<strong>Output: </strong>-1
<strong>Explanation: </strong>It is not possible to color all the walls under the given conditions.</span></pre>
</div><br><p><span style=font-size:18px><strong>Topic Tags : </strong><br><code>Dynamic Programming</code>&nbsp;