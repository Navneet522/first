/*
    Name - Navneet
    Group - B2
*/
//c program for linked list creation, insertion and deletion
#include <stdio.h>
#include <stdlib.h>

struct node {
    int data;
    struct node *next;
};
struct node *head = NULL;//it should be global so that it can be access from anywhere
//for displaying the linked list in reverse order
void display(struct node *head) {
    struct node *p = head;
    while(p!=NULL) {
        printf("%d ", p->data);
        p = p -> next;
    }
}
//for taking input
void input(int data) {
    struct node *q;
    q = (struct node*)malloc(sizeof(struct node));
    q -> data = data;
    q -> next = head;
    head = q;
}
//for inserting a node from beginning
void insertBeginning(int data) {//fixed
    struct node *q;
    q = (struct node*)malloc(sizeof(struct node));
    q -> data = data;
    q -> next = head;
    head = q;
}
//for inserting a node before a given node
void insertBefore(int x, int data) {//fixed
    struct node *q, *p = head;
    q = (struct node*)malloc(sizeof(struct node));
    q -> data = data;
    if(p->data==x)   insertBeginning(data);
    else {
        while(p -> next -> data!=x) {
            p = p -> next;
            if(p->next==NULL) {
                break;
            }
        }
        if(p->next==NULL) {
            printf("Data %d is not found: \n", x);
        }
        else {
            q -> next = p -> next;
            p -> next = q;
        }
    }
}
//for inserting a node after a given node
struct node* insertAfter(int x, int data) {
    struct node *q, *p = head;
    q = (struct node*)malloc(sizeof(struct node));
    q -> data = data;
    while(p -> data!=x) {
        p = p -> next;
        if(p==NULL) break;//if that node after which you want to insert node doesn't exist
    }
    if(p==NULL) {
        printf("Data %d is not found: \n", x);
        return NULL;
    }
    q -> next = p -> next;
    p -> next = q;
}
//for inserting at the end
void insertEnd(int data) {
    struct node *q, *p = head;
    q = (struct node*)malloc(sizeof(struct node));
    while(p -> next!=NULL) {
        p = p -> next;
    }
    q -> data = data;
    q -> next = NULL;
    p -> next = q;
    //head = q;
}
//for deleting head node
void deleteBeginning() {
    struct node *q = head;
    if(head==NULL) {
        printf("Underflow ");
    }
    else {
        head = q -> next;
        free(q);
    }
}
//for deleting last node
void deleteEnd() {
    struct node *q = head, *p;
    while(q -> next!=NULL) {
        p = q;
        q = q -> next;
    }
    free(q);
    p -> next = NULL;
}
//for deleting the given node
void deleteData(int x) {//fixed
    struct node *q = head;
    struct node *p = NULL;
    while((q-> data) !=x) {
        p = q;
        q = q -> next;
        if(q==NULL) {//if node which you want to delete doesn't exist in linked list
            break;
        }
    }
    if(q==NULL) {
        printf("Data %d is not found: ", x);
    }
    else if(p==NULL) {//if node which you want to delete is the head one
        deleteBeginning();
    }
    else if(q -> next == NULL) {//if node which you want to delete is the last one
        deleteEnd();
    }
    else {
        p -> next = q -> next;
        free(q);
    }
}

int main() {
    printf("Enter the number of node:");
    int n;      scanf("%d", &n);
    printf("Enter the nodes:");
    int x;
    for(int i=0; i<n; i++) {
        scanf("%d", &x);
        input(x);
    }
    printf("Created linked list are: ");
    display(head);

    while(1) {
        printf("\nEnter 1 for inserting an element from beginning: ");
        printf("\nEnter 2 for inserting an element from end: ");
        printf("\nEnter 3 for inserting an element before given data: ");
        printf("\nEnter 4 for inserting an element after given data: ");
        printf("\nEnter 5 for deleting an element from beginning: ");
        printf("\nEnter 6 for deleting an element from end: ");
        printf("\nEnter 7 for deleting an given element: ");
        printf("\nEnter 8 for exit: ");
        int choice;         scanf("%d", &choice);
        if(choice==1) {
            printf("Enter the inserted element: ");
            int insrt;  scanf("%d", &insrt);
            insertBeginning(insrt);
            printf("Linked list are: ");
            display(head);
        }
        else if(choice==2) {
            printf("Enter the inserted element from the end: ");
            int insrt;  scanf("%d", &insrt);
            insertEnd(insrt);
            printf("Linked list are: ");
            display(head);
        }
        else if(choice==3) {
            printf("Enter the data and inserted element: ");
            int dat, insrt;     scanf("%d %d", &dat, &insrt);
            insertBefore(dat, insrt);
            printf("Linked list are: ");
            display(head);
        }
        else if(choice==4) {
            printf("Enter the data and inserted element: ");
            int dat, insrt;     scanf("%d %d", &dat, &insrt);
            insertAfter(dat, insrt);
            printf("Linked list are: ");
            display(head);
        }
        else if(choice==5) {
            deleteBeginning();
            printf("Linked list are: ");
            display(head);
        }
        else if(choice==6) {
            deleteEnd();
            printf("Linked list are: ");
            display(head);
        }
        else if(choice==7) {//not working properly
            printf("Enter the data of that element which will be deleted: ");
            int del;    scanf("%d", &del);
            deleteData(del);
            printf("Linked list are: ");
            display(head);
        }
        else if(choice==8) {
            break;
        }
        else {
            printf("Enter the number from 1 to 8: ");
        }
        printf("\n");
    }
    return 0;
}
