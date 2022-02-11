function matrixSearch(matrix, pattern) {
    //Nested loop to iterate matrix
    for (let i = 0; i < matrix.length; i++) {
        for (let j = 0; j < matrix[i].length; j++) {
            //Nested loop to iterate pattern
            let matches = true;
            for (let x = 0; x < pattern.length && matches; x++) {
                for (let y = 0; y < pattern[x].length && matches; y++) {
                    //Breaks loop when matches becomes false, or reaches end of pattern
                    matches = matrix[i + x][j + y] == pattern[x][y]
                }
            }
            //Returns true if entire pattern matched (reached end of loop without matches becoming false)
            if (matches) {
                return true;
            }
        }
    }
    //Return false if no match was found
    return false;
}