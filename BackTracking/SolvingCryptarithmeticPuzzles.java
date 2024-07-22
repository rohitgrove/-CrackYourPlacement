public class SolvingCryptarithmeticPuzzles {
    public boolean exhaustiveSolve(Puzzle puzzle, String lettersToAssign) {
        if (lettersToAssign.isEmpty()) { // no more choices to make
            return puzzleSolved(puzzle); // checks arithmetic to see if it works
        }
        for (int digit = 0; digit < 10; ++digit) { // try all digits
            if (assignLetterToDigit(lettersToAssign.charAt(0), digit)) {
                if (exhaustiveSolve(puzzle, lettersToAssign.substring(1))) {
                    return true;
                }
                unassignLetterFromDigit(lettersToAssign.charAt(0), digit);
            }
        }
        return false; // nothing worked, need to backtrack
    }

    // Assuming these methods exist:
    private boolean assignLetterToDigit(char letter, int digit) {
        // Implementation here
    }

    private void unassignLetterFromDigit(char letter, int digit) {
        // Implementation here
    }

    private boolean puzzleSolved(Puzzle puzzle) {
        // Implementation here
    }

}
