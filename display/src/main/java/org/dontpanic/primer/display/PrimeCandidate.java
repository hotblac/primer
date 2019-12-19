package org.dontpanic.primer.display;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PrimeCandidate {

    private int number;
    private boolean prime;

}
