import { User } from "../classes/user";

export class News {
    private id: number;

    public constructor(
        private text: string,
        private likes: number,
        private dislikes: number,
        private date: Date,
        private user: User
    ) { }
}
