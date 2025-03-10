package com.epam.training.volodymyr_bilan.gmail.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class EmailSendStatus {
    private final boolean isDraftEmpty;
    private final boolean isSentFolderEmpty;
}
