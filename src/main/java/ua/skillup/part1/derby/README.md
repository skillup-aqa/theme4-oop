# Racing Game

Implement the game "Racing":
- Three horses take part in the races.
- At the beginning of the game, the player has 1000 coins. 
- Before each race, he can bet an amount not larger than his budget on the victory of one of the horses; may not participate (put 0) or leave the racetrack (put -1).
- Each horse has a name and a coefficient (inversely proportional to the chance of winning). 
- In the first race, all horses have a 50% chance of winning. 
- The result of the race is determined as follows: the chance of winning is multiplied by a random number between 0 and 1. The results of the horses are sorted in such a way that the highest result is first and the lowest is last. 
- If the player guessed the winner, his winnings are calculated using the formula `Bet * Odds` and added to the player's budget. For example, for a horse with a probability of winning 50%, the coefficient will be 2.0. 
  - If the player bet 100 coins and wins, he will receive 200 coins. 
  - If the player did not guess, the money remains at the racetrack.
- After the race, the odds of winning the horses are updated: the winner increases his chances by half the balance to 100% (`current chances = (100 - current chances) / 2`), second place does not change his chances, third place reduces his chances by half (`current changes = current chances / 2`). Example:
  - After the first round, the chances of the winning horse will be equal to 75%, the second place - 50% and the third - 25%
- If a horse's winning chances are greater than 90% or less than 10%, it is exchanged for a new horse (the name must be new).
- The game ends when the player runs out of money or decides to stop.