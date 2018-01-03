package com.company;

import com.cards.reader.*;

public class Main
{
    public static void main(String[] args)
    {
        ReaderSettings readerSettings = new ReaderSettings("ACS - ACR122U PICC Interface");
        ReaderCredentials readerCredentials = new ReaderCredentials("ABCD1234ABCD1234ABCD1234");

        CardReader reader = new CardReader(readerSettings, readerCredentials, new CardReaderListener() {
            @Override
            public void onCardTap(CardTapResponse cardInfo) {
                if(!cardInfo.IsSuccess) {
                    System.out.println("Failed reading card, error: " + cardInfo.Error);
                    return;
                }

                System.out.println("Card read, user id: " + cardInfo.CardDetails.UserID);
            }

            @Override
            public void onStatusChange(ReaderStatus status) {
                System.out.println("Status changed: " + status);
            }
        });

        reader.listen();
    }
}