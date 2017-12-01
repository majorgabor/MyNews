
export enum Role{
    GUEST, USER, ADMIN
}

export class User {
    private id: number;
    public name: string;
    private age: number;
    private city: string;
    private date: Date;
    public role: Role;

    public constructor(
        private email: string,
        private password: string
    ) { }
}
