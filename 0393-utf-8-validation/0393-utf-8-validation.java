class Solution {
    public boolean validUtf8(int[] data) {
        int remainingBytes = 0;

        for (int num : data) {
            num &= 255;   // keep only 8 bits

            if (remainingBytes == 0) {

                if ((num >> 7) == 0) {
                    continue;
                } else if ((num >> 5) == 0b110) {
                    remainingBytes = 1;
                } else if ((num >> 4) == 0b1110) {
                    remainingBytes = 2;
                } else if ((num >> 3) == 0b11110) {
                    remainingBytes = 3;
                } else {
                    return false;
                }

            } else {

                if ((num >> 6) != 0b10)
                    return false;

                remainingBytes--;
            }
        }

        return remainingBytes == 0;
    }
}