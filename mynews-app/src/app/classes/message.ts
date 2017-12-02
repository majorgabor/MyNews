import { User } from '../classes/user';

export class Message {
    private id: number;
    private date: Date;
    public fromUser: User;

    constructor(    
        private text: string,
        private toUser: User
    ) {}
}
