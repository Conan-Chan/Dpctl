/****************************************************************************

    ePMC - an extensible probabilistic model checker
    Copyright (C) 2017

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.

 *****************************************************************************/

package epmc.command;

import epmc.messages.Message;

/**
 * Messages used in the lumping command plugin of EPMC.
 * This class only contains static fields and methods, and thus is protected
 * from being instantiated.
 * 
 * @author Ernst Moritz Hahn
 */
public final class MessagesCommandExplore {
    /** Base name of resource bundle for the messages. */
    private final static String MESSAGES_COMMAND_EXPLORE = "MessagesCommandExplore";

    /** Exploring the state space of a model. */
    public final static Message EXPLORING = newMessage().setIdentifier("exploring").build();
    /** Finished exploring the state space of a model. */
    public final static Message EXPLORING_DONE = newMessage().setIdentifier("exploring-done").build();

    /**
     * Creates a new message with given identifier with this resource bundle.
     * The parameter may not be {@code null}.
     * 
     * @param message identifier of message to be created
     * @return message created
     */
    private static Message.Builder newMessage() {
        return new Message.Builder().setBundle(MESSAGES_COMMAND_EXPLORE);
    }

    /**
     * Private constructor to prevent instantiation of this class.
     */
    private MessagesCommandExplore() {
    }
}
