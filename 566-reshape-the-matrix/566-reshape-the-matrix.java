class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        if(r*c != mat.length * mat[0].length){
            return mat;
        }
        int mm = 0,nn = 0;
        int[][] response = new int[r][c];
        for(int rr=0;rr<r;rr++){
            for(int cc=0;cc<c;cc++){
                response[rr][cc] = mat[mm][nn];
                nn++;
                if(nn == mat[0].length){
                    nn = 0;
                    mm++;
                }
            }
        }
        return response;
    }
}